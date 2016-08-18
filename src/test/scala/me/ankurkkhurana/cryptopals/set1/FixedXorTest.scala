package me.ankurkkhurana.cryptopals.set1

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by Ankur on 8/18/16.
 */
class FixedXorTest extends WordSpec with Matchers {

  import me.ankurkkhurana.cryptopals.set1.CryptoUtil._

  "FixedXor" should {
    "do xor" in {
      val input1 = hexStringToBytes("1c0111001f010100061a024b53535009181c")
      val input2 = hexStringToBytes("686974207468652062756c6c277320657965")
      val expectedOutput = "746865206b696420646f6e277420706c6179"
      bytesToHexString(FixedXor.xor(input1, input2)) should be(expectedOutput)
    }
  }
}
