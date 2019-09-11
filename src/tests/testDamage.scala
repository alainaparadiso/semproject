package tests

import org.scalatest.FunSuite
import objects.Character

class testDamage extends FunSuite{
  test("Damage 1") {
    val char1: Character = new Character(7, 5, 6,8, 100, 75)
    char1.takeDamage(50)

    assert(char1.curHealth == 50)
    assert(char1.dead == false)
  }

  test("Damage 2") {
    val char1: Character = new Character(6,4,10,4,75,100)
    char1.takeDamage(75)

    assert(char1.curHealth == 0)
    assert(char1.dead == true)
  }

  test("Damage 3") {
    val char1: Character = new Character(6,4,10,4,75,100)
    char1.takeDamage(100)

    assert(char1.curHealth == -25)
    assert(char1.dead == true)
  }
}
