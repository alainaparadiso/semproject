package tests

import org.scalatest.FunSuite
import objects.Character
import objects.Party

class testParty extends FunSuite {
  test("Party 1") {
    val emerald: Character = new Character(8,6,6,7,25,20)
    val amethyst: Character = new Character(10,6,3,4,30,15)
    val opal: Character = new Character(5,10,4,4,35,10)
    val topaz: Character = new Character(4,5,12,8,20,35)

    val party1: Party = new Party(List(emerald, opal))
    val party2: Party = new Party(List(amethyst, topaz))

    amethyst.physicalAttack(emerald)
    emerald.physicalAttack(amethyst)

    assert(amethyst.curHealth == 28)
    assert(emerald.curHealth == 21)
  }

  test("Party 2") {
    val emerald: Character = new Character(15,6,6,7,25,20)
    val amethyst: Character = new Character(10,6,3,4,5,15)
    val opal: Character = new Character(15,10,4,4,35,10)
    val topaz: Character = new Character(4,5,12,8,10,35)

    val party1: Party = new Party(List(emerald, opal))
    val party2: Party = new Party(List(amethyst, topaz))

    amethyst.physicalAttack(emerald)
    topaz.physicalAttack(emerald)

    assert(amethyst.dead == true)
    assert(topaz.dead == true)

    party1.detExperience(party2)

    assert(emerald.experience == 1)
    assert(opal.experience == 1)
  }
}
