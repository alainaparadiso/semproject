package objects

class Party (var characters: List[Character]) {
  /** will determine if all characters in other party are dead */
  def detDefeat(attackedParty: Party): Boolean = {
    var defeat: Boolean = true
    for (char <- attackedParty.characters) {
      if (char.dead == false) {
        defeat = false
      }
    }
    defeat
  }

  /** will determine the experience gained from an attacked party */
  def detExperience(attackedParty: Party): Unit = {
    var totExp: Int = 0
    if (detDefeat(attackedParty) == true) {
      for (char <- attackedParty.characters) {
        totExp += char.level
      }
    }
    val cutOfExp: Int = totExp / this.characters.length

    for (char <- this.characters) {
      char.experience += cutOfExp
      char.levelUp()
    }
  }
}
