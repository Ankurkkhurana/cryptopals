package me.ankurkkhurana.cryptopals.set1

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by Ankur on 8/16/16.
 * http://cryptopals.com/sets/1/challenges/1
 */
class Base64Test extends WordSpec with Matchers {
  import CryptoUtil._
  "Base64 convertor" should {
    "convert bytes to base64 properly" in {
      val input = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
      val expectedOutput = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
      Base64.convertToBase64(hexStringToBytes(input)) should be (expectedOutput)
    }
  }
}
