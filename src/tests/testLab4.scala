package tests

import objects.{Mage, Tank}
import org.scalatest.FunSuite

class testLab4 extends FunSuite {
  test("Joe's Stats") {
    val char1: Tank = new Tank("Joe")

    assert(char1.attack == 10, char1.attack)
    assert(char1.defense == 20, char1.defense)
    assert(char1.magAttack == 5, char1.magAttack)
    assert(char1.magDefense == 15, char1.magDefense)
    assert(char1.maxHealth == 300, char1.maxHealth)
    assert(char1.maxMagic == 50, char1.maxMagic)
    assert(char1.battle sameElements Array("Physical Attack","Magic Attack","",""))
  }

  test("Logan's Stats") {
    val char2: Mage = new Mage("Logan")

    assert(char2.attack == 5, char2.attack)
    assert(char2.defense == 10, char2.defense)
    assert(char2.magAttack == 20, char2.magAttack)
    assert(char2.magDefense == 20, char2.magDefense)
    assert(char2.maxHealth == 75, char2.maxHealth)
    assert(char2.maxMagic == 200, char2.maxMagic)
    assert(char2.battle sameElements Array("Physical Attack", "Magic Attack", "", ""))
  }

  test("Joe's LevelUp One") {
    val char1: Tank = new Tank("Joe")

    char1.experience = 10
    char1.curHealth = 1
    char1.curMagic = 1
    char1.levelUp()

    assert(char1.attack == 11, char1.attack)
    assert(char1.defense == 21, char1.defense)
    assert(char1.curHealth == char1.maxHealth, char1.curHealth)
  }

  test("Logan's LevelUp One") {
    val char2: Mage = new Mage("Logan")

    char2.experience = 10
    char2.curHealth = 1
    char2.curMagic = 1
    char2.levelUp()

    assert(char2.magAttack == 21)
    assert(char2.magDefense == 21)
    assert(char2.maxMagic == 210)
    assert(char2.curMagic == char2.maxMagic)
    assert(char2.curHealth == char2.maxHealth)
  }

  test("Joe's LevelUp Multiple") {
    val char1: Tank = new Tank("Joe")

    char1.experience = 30
    char1.curHealth = 1
    char1.curMagic = 1
    char1.levelUp()

    assert(char1.attack == 12, char1.attack)
    assert(char1.defense == 22, char1.defense)
    assert(char1.magAttack == 6, char1.magAttack)
    assert(char1.magDefense == 16, char1.magDefense)
    assert(char1.curHealth == char1.maxHealth, char1.curHealth)
    assert(char1.curMagic == char1.maxMagic, char1.maxMagic)
    assert(char1.battle sameElements Array("Physical Attack","Magic Attack","Fortify",""))
  }

  test("Logan's LevelUp Multiple") {
    val char2: Mage = new Mage("Logan")

    char2.experience = 30
    char2.curHealth = 1
    char2.curMagic = 1
    char2.levelUp()

    assert(char2.magAttack == 22)
    assert(char2.magDefense == 22)
    assert(char2.maxMagic == 220)
    assert(char2.attack == 6)
    assert(char2.defense == 11)
    assert(char2.curMagic == char2.maxMagic)
    assert(char2.curHealth == char2.maxHealth)
    assert(char2.battle sameElements Array("Physical Attack","Magic Attack","Absorb",""))
  }

  test("BATTLE!!") {
    val char1: Tank = new Tank("Joe")
    val char2: Mage = new Mage("Logan")

    char1.level = 11
    char1.levelUp()
    char1.curHealth = 200
    char2.level = 11
    char2.levelUp()

    char1.physicalAttack(char2)
    char1.magicAttack(char2)
    char1.fortify()
    char1.heal(char1)

    assert(char1.curHealth == 220)
    assert(char1.attack == 9)
    assert(char1.defense == 21)
    assert(char2.curHealth == 75)

    char2.absorb(char1)
    char2.doubleUp(char1)

    assert(char2.curMagic == 175)
    assert(char1.curHealth == 175)

  }
}
