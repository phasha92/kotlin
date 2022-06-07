fun main() {
    val converter = Converters
    converter.get("usd").convertToRub(300.0)
    converter.get("eur").convertToRub(75.0)
    converter.get("nzd").convertToRub(400.0)
    converter.get("grn").convertToRub(555.0)
    converter.get("wasd").convertToRub(777.0)

}