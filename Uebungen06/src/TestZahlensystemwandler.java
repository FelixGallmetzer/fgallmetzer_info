
public class TestZahlensystemwandler
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("getDigit(\'0\') ergibt " + MeinZahlensystemwandler.getDigit('0'));
		System.out.println("getDigit(\'A\') ergibt " + MeinZahlensystemwandler.getDigit('A'));
		System.out.println("getDigit(\'!\') ergibt " + MeinZahlensystemwandler.getDigit('!'));
		System.out.println("getDigit(0) ergibt " + MeinZahlensystemwandler.getDigit(0));
		System.out.println("getDigit(10) ergibt " + MeinZahlensystemwandler.getDigit(10));
		System.out.println("getDigit(42) ergibt " + MeinZahlensystemwandler.getDigit(42));
		System.out.println("numToDec(\"01110110\", 2) ergibt " + MeinZahlensystemwandler.numToDec("01110110", 2));
		System.out.println("numToDec(\"170712\", 8) ergibt " + MeinZahlensystemwandler.numToDec("170712", 8));
		System.out.println("numToDec(\"170712\", 7) ergibt " + MeinZahlensystemwandler.numToDec("170712", 7));
		System.out.println("decToNum(\"118, 2\") ergibt " + MeinZahlensystemwandler.decToNum(118, 2));
		System.out.println("decToNum(\"61898, 8\") ergibt " + MeinZahlensystemwandler.decToNum(61898, 8));
		System.out.println("hexToDec(\"130\") ergibt " + MeinZahlensystemwandler.hexToDec("130"));
		System.out.println("hexToDec(\"A5\") ergibt " + MeinZahlensystemwandler.hexToDec("A5"));
		System.out.println("decToHex(\"304\") ergibt " + MeinZahlensystemwandler.decToHex(304));
		System.out.println("decToHex(\"165\") ergibt " + MeinZahlensystemwandler.decToHex(165));
		System.out.println("dualToDec(\"1110011\") ergibt " + MeinZahlensystemwandler.dualToDec("1110011"));
		System.out.println("dualToDec(\"101\") ergibt " + MeinZahlensystemwandler.dualToDec("101"));
		System.out.println("decToDual(\"115\") ergibt " + MeinZahlensystemwandler.decToDual(115));
		System.out.println("decToDual(\"5\") ergibt " + MeinZahlensystemwandler.decToDual(5));
		System.out.println("numToNum(\"\") ergibt " + MeinZahlensystemwandler.numToNum("123",16,5));
		System.out.println("numToNum(\"\") ergibt " + MeinZahlensystemwandler.numToNum("null",16,5));
		}
}