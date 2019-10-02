/**package tests

import org.scalatest.FunSuite
import objects.Character

class testAttack extends FunSuite {
  test("Attack 1") {
    val char1 = new Character(10,5,5,5,100,100)
    val char2 = new Character(8,6,4,5,100,100)

    char1.physicalAttack(char2)
    char2.magicAttack(char1)

    assert(char1.curHealth == 97)
    assert(char2.curHealth == 100)
    assert(char1.curMagic == 95)
  }

  test("Attack 2") {
    val char1 = new Character(10,5,5,5,100,100)
    val char2 = new Character(8,6,4,5,100,0)

    char1.magicAttack(char2)

    assert(char1.curHealth == 100)
  }
}
*/