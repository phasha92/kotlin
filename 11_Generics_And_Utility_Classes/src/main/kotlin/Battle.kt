import kotlin.random.Random

class Battle {
    private val teamFirst = Team("First")
    private val teamSecond = Team("Second")

    var endOfBattle = false

    fun getBattleStage() : BattleState {

        return when {
            teamFirst.team.count { !it.isKilled } == 0 -> {
                endOfBattle = true
                BattleState.WinSecond(teamSecond)
            }
            teamSecond.team.count { !it.isKilled } == 0 -> {
                endOfBattle = true
                BattleState.WinFirst(teamFirst)
            }
            else -> BattleState.Progress(teamFirst, teamSecond)
        }

    }

    fun iterateTheBattle() {
        battleStage(teamFirst, teamSecond)
        battleStage(teamSecond, teamFirst)

    }

    private fun battleStage(team1 : Team, team2 : Team) {
        team1.team.forEach {
            if (!it.isKilled)
                if (it is Medical) {
                    when (Random.nextBoolean()) {
                        true -> it.teatment(team1.team.random())
                        else -> it.attack(team2.team.random())
                    }
                } else
                    it.attack(team2.team.random())
        }
        println()
    }
}