package objects

class Mage(name: String) extends Character(name,5,10,20,20,75,200) {
  val orgAtt = attack
  val orgDef = defense
  val orgMAtt = magAttack
  val orfMDef = magDefense
  var isDouble = false
  var isAbsorb = false

  var battle: Array[String] = Array("Physical Attack","Magic Attack","","")

  override def levelUp(): Unit = {
    while (experience >= levelCutoff) {
      level += 1
      experience -= levelCutoff
      if (level % 3 == 0) {
        attack += 1
        defense += 1
      }
      else if (level % 2 == 0){
        magAttack += 1
        magDefense += 1
        maxMagic += 10
      }
      levelCutoff += 1
    }
    curHealth = maxHealth
    curMagic = maxMagic
    if (level >= 5) {
      battle(2) = "Absorb"
    }
    if (level >= 10) {
      battle(3) = "Double Up"
    }
  }

  /** can use at level 5, will absorb maximum 15 points magic from opponent */
  def absorb(otherChar: Character): Unit = {
    val totalAvail: Int = math.min(otherChar.curMagic, 15)
    otherChar.curMagic -= totalAvail
    this.curMagic += totalAvail
  }

  /** can use at level 10, will do 3x damage for 2x magic */
  def doubleUp(otherChar: Character): Unit = {
    val damage: Int = 3 * this.magAttack - otherChar.magDefense

    if (damage >= 0) {
      if (this.curMagic >= damage) {
        otherChar.takeDamage(damage)
        val newMag = this.curMagic - (2 * this.magAttack)
        this.curMagic = newMag
      }
    }
  }

  override def takeAction(action: String, otherChar: Character): Unit = {
    if (action == "Physical Attack") {
      this.physicalAttack(otherChar)
    }
    else if (action == "Magic Attack") {
      this.magicAttack(otherChar)
    }
    else if (action == "Absorb" && this.level >= 5) {
      this.absorb(otherChar)
    }
    else if (action == "Heal" && this.level >= 10) {
      this.doubleUp(otherChar)
    }
  }
}
