sealed class FieldState {
    object Open: FieldState() {
        override fun toString() = " "
    }

    object Close: FieldState() {
        override fun toString() = "X"
    }

    data class Number(var number: Int = 0): FieldState() {
        override fun toString() = "$number"
    }
}
