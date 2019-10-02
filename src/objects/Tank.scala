package objects


class Tank(name: String) extends Character(name,10,20,5,15,300,50){
  var orgAtt = attack
  var orgDef = defense
  var isFortify = false
  var isHeal = false

  var battle: Array[String] = Array("Physical Attack","Magic Attack","","")

  def reset(): Unit = {
    attack = orgAtt
    defense = orgDef
  }

  override def levelUp(): Unit = {
    while (experience >= levelCutoff) {
      level += 1
      experience -= levelCutoff
      curHealth = maxHealth
      curMagic = maxMagic
      if (level % 2 == 0) {
        attack += 1
        orgAtt = attack
        defense += 1
        orgDef = defense
      }
      else if (level % 3 == 0) {
        magAttack += 1
        magDefense += 1
      }
      levelCutoff += 1
    }
    if (level >= 5) {
      battle(2) = "Fortify"
    }
    if (level >= 10) {
      battle(3) = "Heal"
    }
  }

  /** able to use at level 5, trade one attack for one defense point*/
  def fortify(): Unit = {
    if (attack > 0) {
      attack -= 1
      defense += 1
    }
  }

  /** able to use at level 10, can heal any character 20 points */
  def heal(char: Character): Unit = {
    char.curHealth = math.min(char.curHealth + 20, maxHealth)
  }

  override def takeAction(action: String, otherChar: Character): Unit = {
    if (action == "Physical Attack") {
      this.physicalAttack(otherChar)
    }
    else if (action == "Magic Attack") {
      this.magicAttack(otherChar)
    }
    else if (action == "Fortify" && this.level >= 5) {
     this.fortify()
    }
    else if (action == "Heal" && this.level >= 10) {
      this.heal(otherChar)
    }
  }
}
