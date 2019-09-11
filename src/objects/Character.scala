package objects

class Character(var attack: Int, var defense: Int, var magAttack: Int, var magDefense: Int, var maxHealth: Int, var maxMagic: Int) {
  var curHealth: Int = maxHealth
  var curMagic: Int = maxMagic
  var dead: Boolean = false
  var experience: Int = 0
  var level: Int = 0

  def takeDamage(damage: Int): Unit = {
    curHealth = curHealth - damage

    if (curHealth <= 0) {
      dead = true
    }
  }

  def levelUp(): Unit = {
    if (experience >= 100){
      level += 1
      experience -= 100
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
    }
  }

  def physicalAttack(otherChar: Character): Unit = {
    val damage: Int = otherChar.attack - this.defense

    this.takeDamage(damage)

    otherChar.experience += damage
    otherChar.levelUp()
  }

  def magicAttack(otherChar: Character): Unit = {
    val damage: Int = otherChar.magAttack - this.magDefense

    if (damage >= 0) {
      if (otherChar.curMagic >= damage) {
        this.takeDamage(damage)
        val newMag = otherChar.curMagic - otherChar.magAttack
        otherChar.curMagic = newMag
        otherChar.experience += (damage * 2)
      }
    }
    otherChar.levelUp()
  }

}
