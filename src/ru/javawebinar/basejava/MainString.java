package ru.javawebinar.basejava;

public class MainString {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"1", "2", "3", "4", "5"};
        StringBuilder sb = new StringBuilder();
        for (String str : stringArray) {
            sb.append(str).append(", ");
        }
        System.out.println(sb);
        String str1 = "abc";
        String str3 = "c";
        String str2 = ("ab" + str3).intern();
        //noinspection StringEquality
        System.out.println(str1 == str2);
    }
}
