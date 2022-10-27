open class Hero{
    open var heroName = ""
    open var mainAttribute = ""
    open var strengthStats: Double = 10.0
    open var agilityStats: Double = 10.0
    open var intelligenceStats: Double = 10.0
    open var moveSpeed = 290
    var manaPoll = intelligenceStats * 12
    var healthPoints = strengthStats * 20
    var armorStats = agilityStats * 0.167
    open var side = "Radiant"

    open var level = 1
        set(value) {
            if(value <= 30){
                field = value
            }
            else{
                println("Incorrect value")
            }}

    open var levelQ = 0
        set(value) {
            if(value <= 4){
                field = value
            }
            else{
                println("Incorrect value")
            }}

    open fun skillQ(target: Hero){
        println("Casted Q-skill!")
    }

    open var levelW = 0
        set(value) {
            if(value <= 4){
                field = value
            }
            else{
                println("Incorrect value")
            }}

    open fun skillW(target: Hero){
        println("Casted W-skill!")
    }

    open var levelE = 0
        set(value) {
            if(value <= 4){
                field = value
            }
            else{
                println("Incorrect value")
            }}

    open fun skillE(target: Hero){
        println("Casted W-skill!")
    }

    open var levelR = 0
        set(value) {
            if(value <= 3){
                field = value
            }
            else{
                println("Incorrect value")
            }}

    open fun skillR(target: Hero){
        println("Casted W-skill!")
    }
}

class CrystalMaiden(): Hero(){
    override var heroName = "Crystal Maiden"
    override var mainAttribute =  "Intelligence"
    override var strengthStats = 17 + (level - 1) * 2.2
    override var agilityStats = 16 + (level - 1) * 1.6
    override var intelligenceStats = 16 + (level - 1) * 3.3
    override var side = "Radiant"


    override fun skillQ(target: Hero) {
        if(target.side == side) {
            println(
                "Casted Crystal Nova! $heroName mana's decreased on ${95 + levelQ * 20}. ${target.heroName} gets ${
                    when (levelQ) {
                        4 -> 260
                        else -> 130 + (levelQ - 1) * 40
                    }
                } damage"
            )
            when (levelQ) {
                4 -> target.healthPoints -= 260
                else -> target.healthPoints -= 130 + (levelQ - 1) * 40
            }
        }
        else{
            println("You can't cast this skill to your teammate")
        }
    }


    override fun skillW(target: Hero){
        if(target.side == side) {
        println("Casted Frostbite! $heroName mana's decreased on ${(levelW * 10 + 115)}. ${target.heroName} gets ${(levelW * 0.5 + 1) * 100} damage")
        target.healthPoints -= (levelW * 0.5 + 1) * 100
        }
    else{
        println("You can't cast this skill to your teammate")
    }

    }

    override fun skillE(target: Hero) {
        println("Arcane Aura restores ${0.3 + levelE * 0.3} per second")
    }

    override fun skillR(target: Hero){
        if(target.side == side) {
        println("Casted Freezing Field! $heroName mana's decreased on ${levelR * 200}. ${target.heroName} gets ${when(levelR){
            1 -> 1050
            2 -> 1700
            3 -> 2500
            else -> 0
        }
        } damage")
        }
        else{
            println("You can't cast this skill to your teammate")
        }
    }
}


class Pudge(): Hero(){
    override var heroName = "Pudge"
    override var mainAttribute =  "Strength"
    override var strengthStats = 25 + (level - 1) * 3.0
    override var agilityStats = 14 + (level - 1) * 1.4
    override var intelligenceStats = 16 + (level - 1) * 1.8
    override var side = "Dire"


    override fun skillQ(target: Hero){
        if(target.side == side) {
            println("Casted Meat Hook! $heroName mana's decreased on 110. ${target.heroName} gets ${80 + levelQ * 70} damage")
            target.healthPoints -= 80 + levelQ * 70
        }
        else{
            println("You can't cast this skill to your teammate")
        }
    }


    override fun skillW(target: Hero) {
        println("Rot damages ${levelW * 30} per second")
    }


    override fun skillE(target: Hero){
        println("Skill Flesh Heap blocks ${2 + 6 * levelE}")
    }

    override fun skillR(target: Hero){
        if(target.side == side) {
            println(
                "Casted Dismember! $heroName mana's decreased on ${
                    when (levelR) {
                        1 -> 100
                        2 -> 130
                        3 -> 170
                        else -> 0
                    }
                }. ${target.heroName} gets ${60 + levelR * 20 + strengthStats * levelR * 0.3} damage per second"
            )
        }
        else{
            println("You can't cast this skill to your teammate")
        }
    }

}


fun main() {
    var Aboba = CrystalMaiden()
    Aboba.apply {
        level = 16
        levelQ = 4
        levelW = 4
        levelE = 4
        levelR = 3
    }
    var Boba = Pudge()
    Boba.apply {
        level = 16
        levelQ = 4
        levelW = 4
        levelE = 4
        levelR = 3
    }
}