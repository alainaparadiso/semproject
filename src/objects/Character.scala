package objects

class Character(var Attack: Int, var Defense: Int, var magAttack: Int, var magDefense: Int, var maxHealth: Int, var maxMagic: Int) {
  var curHealth: Int = maxHealth
  var curMagic: Int = maxMagic
  var dead: Boolean = false

  def takeDamage(damage: Int): Unit = {
    curHealth = curHealth - damage

    if (curHealth <= 0) {
      dead = true
    }
  }

  def physicalAttack(otherChar: Character): Unit = {
    val damage: Int = otherChar.Attack - this.Defense

    this.takeDamage(damage)
  }

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
