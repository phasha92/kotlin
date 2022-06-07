sealed class BattleState {
    data class Progress(val team1 : Team, val team2 : Team) : BattleState() {
        override fun toString() : String {
            return """
                |статистика:
                |
                |команда ${team1.name}
                |живых ${team1.team.count { !it.isKilled }}
                |общее количество здоровья  ${
                team1.team.sumOf {
                    it as AbstractWarrior
                    it.health
                }
            }   
            |
                |команда ${team2.name}
                |живых ${team2.team.count { !it.isKilled }}
                |общее количество здоровья ${
                team2.team.sumOf {
                    it as AbstractWarrior
                    it.health
                }
            }
            |
            """.trimMargin()
        }
    }

    data class WinFirst(val team : Team) : BattleState() {
        override fun toString() : String {
            return "Победила команда ${team.name}"
        }
    }

    data class WinSecond(val team : Team) : BattleState() {
        override fun toString() : String {
            return "Победила команда ${team.name}"
        }
    }

}