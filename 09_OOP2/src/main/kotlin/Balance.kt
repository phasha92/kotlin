class Balance(
    var debit : Double,
    var credit : Double
){
    constructor( debit : Double):this(debit,credit = 0.0)
}