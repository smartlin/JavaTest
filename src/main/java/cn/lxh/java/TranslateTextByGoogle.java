///*
// * Copyright 2020 Google LLC
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package cn.lxh.java;
//
//
//import com.google.cloud.translate.v3.LocationName;
//import com.google.cloud.translate.v3.TranslateTextRequest;
//import com.google.cloud.translate.v3.TranslateTextResponse;
//import com.google.cloud.translate.v3.TranslationServiceClient;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
//public class TranslateTextByGoogle {
//	public static int translatedTextLength = 0;
//	public static void main(String[] args) throws IOException {
//		translateText();
//		/*  Translate translate = TranslateOptions.getDefaultInstance().getService();
//
//		  Detection detection = translate.detect("Hola");
//		  String detectedLanguage = detection.getLanguage();
//
//		  Translation translation = translate.translate(
//		      "World",
//		      TranslateOption.sourceLanguage("en"),
//		      TranslateOption.targetLanguage(detectedLanguage));
//
//		  System.out.printf("Hola %s%n", translation.getTranslatedText());*/
//	}
//
//  public static void translateText() throws IOException {
//    // TODO(developer): Replace these variables before running the sample.
//    String projectId = "apitranslation-200824";
//    // Supported Languages: https://cloud.google.com/translate/docs/languages2627
//    String targetLanguage = "es";
//    String text = "hello world";
//    translateText(projectId, targetLanguage, text);
//  }
//
//  // Translating Text
//  public static String translateText(String projectId, String targetLanguage, String text){
//
//
//    try (TranslationServiceClient client = TranslationServiceClient.create()) {
//    	Thread.sleep(10);
//      LocationName parent = LocationName.of(projectId, "global");
//
//      TranslateTextRequest request =
//          TranslateTextRequest.newBuilder()
//              .setParent(parent.toString())
//              .setMimeType("text/plain")
//              .setTargetLanguageCode(targetLanguage)
//              .addContents(text)
//              .build();
//     /* translations {
//    	  translated_text: "(Hapus alarm)"
//    	  detected_language_code: "en"
//    	}*/
//      TranslateTextResponse response = client.translateText(request);
//
//      String translatedTextnow = response.getTranslationsList().get(0).getTranslatedText();
//
//     System.err.println(text+"------- "+translatedTextnow);
//	  translatedTextLength += getLength(translatedTextnow);
//	  return translatedTextnow;
//
//     /* for (Translation translation : response.getTranslationsList()) {
//    	  System.out.println(text+" -----："+translation.getTranslatedText()+"\n");
//    	  translatedTextLength += getLength(translation.getTranslatedText());
//    	  System.out.println("字节共："+translatedTextLength);
//    	  return translation.getTranslatedText();
//      }*/
//    } catch (Exception e) {
//    	System.err.println("------谷歌API接口出错！ 当前翻译字节："+translatedTextLength);
//	}
//	return text;
//  }
//
//
//
//  /**
//   * 获取字符串的字符长度
//   * 每月前50万字符免费（$10赠金支付）
//   * 50万以上到10亿字符，每100万字符$20
//   *
//   * **/
//  public static int getLength(String translatedText) {
//		//String aString = "这是一个测试串，This is a test string.";
//		String anotherString = null;
//		try {
//			anotherString = new String(translatedText.getBytes("GBK"), "ISO8859_1");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		return anotherString.length();
//  }
//
//}