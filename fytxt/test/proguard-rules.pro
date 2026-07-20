-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.view.View { public <init>(android.content.Context); }
-keep class android.widget.** { *; }
-keep class android.view.** { *; }
-dontwarn java.lang.reflect.AnnotatedType
-dontwarn com.highcapable.hikage.**