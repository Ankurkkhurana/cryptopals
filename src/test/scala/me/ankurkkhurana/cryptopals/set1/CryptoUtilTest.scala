package me.ankurkkhurana.cryptopals.set1

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by Ankur on 8/16/16.
 */
class CryptoUtilTest extends WordSpec with Matchers {
  "CryptoUtil" should {

    "Convert to bit array properly" in {
      CryptoUtil.byteToBooleanArray(255.toByte) should be(Array(true, true, true, true, true, true, true, true))
      CryptoUtil.byteToBooleanArray(3.toByte) should be(Array(true, true, false, false, false, false, false, false))
      CryptoUtil.byteToBooleanArray(9.toByte) should be(Array(true, false, false, true, false, false, false, false))
    }

    "Convert back from bit array properly to byte" in {
      (1 to 255).foreach(p => {
        CryptoUtil.bitArrayToByte(CryptoUtil.byteToBooleanArray(p.toByte)) should be(p.toByte)
      })
    }

    "Convert from hex to bytes and back" in {
      CryptoUtil.bytesToHexString(CryptoUtil.hexStringToBytes("1234")) should be("1234")
    }
  }
}
