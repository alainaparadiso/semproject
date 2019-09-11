package tests

import org.scalatest.FunSuite
import objects.Character

class testExperience extends FunSuite {
  test("Experience 1") {
    val char1 = new Character(10,5,5,5,100,100)
    val char2 = new Character(8,6,4,5,100,100)

    char2.experience = 99

    char1.physicalAttack(char2)

    assert(char2.attack == 8)
    assert(char2.defense == 6)
    assert(char2.magAttack == 5)
    assert(char2.magDefense == 6)
    assert(char2.level == 1)
    assert(char2.experience == 2)
  }

}
