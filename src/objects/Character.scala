package objects

class Character(var attack: Int, var defense: Int, var magAttack: Int, var magDefense: Int, var maxHealth: Int, var maxMagic: Int) {
  var curHealth: Int = maxHealth
  var curMagic: Int = maxMagic
  var dead: Boolean = false
  var experience: Int = 0
  var level: Int = 1
  var levelCutoff: Int = 5

  /** will put damage taken into effect */
  def takeDamage(damage: Int): Unit = {
    curHealth = curHealth - damage
    if (curHealth <= 0) {
      dead = true
    }
  }

  /** will determine the amount of experience this player will release upon defeat */
  def detExperience(): Int = {
    var addedExp: Int = 0
    if (this.dead == true) {
      addedExp = this.level * 5
    }
    addedExp
  }

  /** will check if a character has enough exp to level up, and will spend the exp points if able to */
  def levelUp(): Unit = {
    if (experience >= levelCutoff){
      level += 1
      experience -= levelCutoff
      if (level % 2 == 0) {
        attack += 1
        defense += 1
        curHealth = maxHealth
      }
      else {
        magAttack += 1
        magDefense += 1
        curMagic = maxMagic
      }
      levelCutoff += 1
    }
  }

  /** will execute a physical attack where this player is being attacked by the otherChar */
  def physicalAttack(otherChar: Character): Unit = {
    val damage: Int = otherChar.attack - this.defense

    if (damage >= 0) {
      this.takeDamage(damage)
    }
  }

  /** will execute a magic attack where this player is being attacked by otherChar and will spend magic to do so */
  def magicAttack(otherChar: Character): Unit = {
    val damage: Int = otherChar.magAttack - this.magDefense

    if (damage >= 0) {
      if (otherChar.curMagic >= damage) {
        this.takeDamage(damage)
        val newMag = otherChar.curMagic - otherChar.magAttack
        otherChar.curMagic = newMag
      }
    }
  }

}
