package drawsine;


public class SettingData {
private static String Amplitude;
private static String Frequency;
private static String Length;
public static String getAmplitude() {
	return Amplitude;
}
public static void setAmplitude(String amplitude) {
	SettingData.Amplitude = amplitude;
}
public static String getFrequency() {
	return Frequency;
}
public static void setFrequency(String frequency) {
	SettingData.Frequency = frequency;
}
public static String getLength() {
	return Length;
}
public static void setLength(String length) {
	SettingData.Length = length;
}

}