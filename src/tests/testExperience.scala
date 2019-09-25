package tests

import org.scalatest.FunSuite
import objects.Character

class testExperience extends FunSuite {
  test("Experience 1") {
    val char1 = new Character(10,5,5,5,100,100)
    val char2 = new Character(8,6,4,5,1,100)

    char2.experience = 5

    char1.physicalAttack(char2)
    char2.levelUp()

    assert(char2.attack == 9)
    assert(char2.defense == 7)
    assert(char2.magAttack == 4)
    assert(char2.magDefense == 5)
    assert(char2.level == 2)
    assert(char2.experience == 0)
  }

  test("Experience 2") {
    val char1 = new Character(10,5,5,5,100,100)

    char1.experience = 20
    char1.levelUp()

    assert(char1.attack == 12)
    assert(char1.defense == 7)
    assert(char1.magAttack == 6)
    assert(char1.magDefense == 6)
    assert(char1.level == 4)
    assert(char1.experience == 2)
  }

}
