//package niray.hook.migameadhook;
//com.xiaomi.gamecenter.sdk.ui.actlayout.ViewForLoginMessage;
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Handler;
//import android.text.Html;
//import android.text.Spannable;
//import android.text.SpannableStringBuilder;
//import android.text.TextUtils;
//import android.text.method.LinkMovementMethod;
//import android.text.style.URLSpan;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.animation.AnimationUtils;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//
//import com.xiaomi.gamecenter.sdk.component.MessageCenter;
//import com.xiaomi.gamecenter.sdk.component.h;
//import com.xiaomi.gamecenter.sdk.g.j;
//import com.xiaomi.gamecenter.sdk.protocol.login.MessageInfo;
//import com.xiaomi.gamecenter.sdk.ui.MiActivity;
//import com.xiaomi.gamecenter.sdk.ui.MiTextView;
//import com.xiaomi.gamecenter.sdk.ui.UiUtils;
//import com.xiaomi.gamecenter.sdk.ui.UiUtils.SchemeType;
//
//import cn.com.wali.basetool.d;
//import miuipub.payment.ai;
//
//public class ViewForLoginMessage extends MiActivity implements View.OnClickListener, h {
//    private static final int o = 10000;
//    private static final int p = 20000;
//    private static final int q = 30000;
//    private static final int r = 40000;
//    private static final int s = 50000;
//    private static final int t = 60000;
//    private static final int u = 70000;
//    Handler i = new az(this);
//    private MessageCenter j;
//    private d k;
//    private String l;
//    private boolean m = true;
//    private MessageInfo n;
//
//    private void a(Context paramContext, String paramString) {
//        UiUtils.SchemeType localSchemeType = UiUtils.a(paramString);
//        if (localSchemeType == UiUtils.SchemeType.HTTP) {
//            Intent localIntent1 = new Intent(paramContext, ViewMessageWeb.class);
//            localIntent1.putExtra("url", paramString);
//            localIntent1.putExtra("hasuserinfo", this.n.j());
//            localIntent1.putExtra("action_request", e());
//            localIntent1.putExtra("app", this.h);
//            localIntent1.putExtra("title", this.l);
//            paramContext.startActivity(localIntent1);
//        }
//        do {
//            return;
//            if (localSchemeType == UiUtils.SchemeType.GAMECENTER) {
//                Intent localIntent2 = new Intent("android.intent.action.VIEW");
//                localIntent2.setData(Uri.parse(paramString));
//                localIntent2.addFlags(268435456);
//                if (UiUtils.a(paramContext, localIntent2)) {
//                    try {
//                        paramContext.startActivity(localIntent2);
//                        return;
//                    } catch (Exception localException) {
//                        localException.printStackTrace();
//                        return;
//                    }
//                }
//                Toast.makeText(paramContext, "������������������", 0).show();
//                return;
//            }
//        } while (localSchemeType != UiUtils.SchemeType.MIBICENTER);
//        ai.a(paramContext).a((Activity) paramContext);
//    }
//
//    private void a(MessageInfo paramMessageInfo) {
//        this.j.setViewMode(false);
//        this.j.startAnimation(AnimationUtils.loadAnimation(this, 2130968583));
//        String str1 = paramMessageInfo.g();
//        this.l = str1;
//        String str2 = paramMessageInfo.h();
//        this.j.setVisibility(0);
//        this.j.setTitleText(str1);
//        a(str2);
//    }
//
//    private void a(String paramString) {
//        MiTextView localMiTextView = this.j.a();
//        localMiTextView.setMovementMethod(LinkMovementMethod.getInstance());
//        localMiTextView.setTextColor(-10197916);
//        localMiTextView.setLineSpacing(1.0F, 1.3F);
//        if (!TextUtils.isEmpty(paramString)) {
//            localMiTextView.setText(Html.fromHtml(paramString));
//            CharSequence localCharSequence = localMiTextView.getText();
//            if ((localCharSequence instanceof Spannable)) {
//                SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localCharSequence);
//                int i1 = paramString.length();
//                Spannable localSpannable = (Spannable) localMiTextView.getText();
//                URLSpan[] arrayOfURLSpan = (URLSpan[]) localSpannable.getSpans(0, i1, URLSpan.class);
//                if ((arrayOfURLSpan != null) && (arrayOfURLSpan.length > 0)) {
//                    int i2 = arrayOfURLSpan.length;
//                    for (int i3 = 0; i3 < i2; i3++) {
//                        URLSpan localURLSpan = arrayOfURLSpan[i3];
//                        localSpannableStringBuilder.removeSpan(localURLSpan);
//                        localSpannableStringBuilder.setSpan(new bc(localURLSpan.getURL(), e(), this.h, this.n, this.l), localSpannable.getSpanStart(localURLSpan), localSpannable.getSpanEnd(localURLSpan), 34);
//                    }
//                }
//                localMiTextView.setText(localSpannableStringBuilder);
//            }
//        }
//    }
//
//    private void a(boolean paramBoolean1, boolean paramBoolean2) {
//        Intent localIntent = new Intent();
//        localIntent.putExtra("success", paramBoolean1);
//        localIntent.putExtra("onkey", paramBoolean2);
//        a(this, -1, localIntent);
//        finish();
//        overridePendingTransition(0, 0);
//    }
//
//    private void f() {
//        new ba(this).start();
//    }
//
//    private void g() {
//        this.l = this.n.g();
//        String str = this.n.n();
//        if (h()) {
//            str = this.n.o();
//        }
//        if (!TextUtils.isEmpty(str)) {
//            new bb(this, str).execute(new Void[0]);
//        }
//    }
//
//    private boolean h() {
//        return getResources().getConfiguration().orientation == 1;
//    }
//
//    protected View a() {
//        LinearLayout localLinearLayout = new LinearLayout(this);
//        localLinearLayout.setGravity(17);
//        localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
//        this.j = new MessageCenter(this, this, this);
//        this.j.setVisibility(4);
//        localLinearLayout.addView(this.j);
//        return localLinearLayout;
//    }
//
//    public void a(boolean paramBoolean) {
//        if (paramBoolean) {
//            this.m = false;
//            return;
//        }
//        this.m = true;
//    }
//
//    protected RelativeLayout.LayoutParams b() {
//        this.b.setBackgroundColor(getResources().getColor(2131362091));
//        return new RelativeLayout.LayoutParams(-1, -1);
//    }
//
//    public void onClick(View paramView) {
//        int i1 = paramView.getId();
//        if ((i1 == this.j.c()) || (i1 == this.j.d())) {
//            if (!j.a()) {
//            }
//        }
//        while ((i1 != this.j.e()) || (j.a())) {
//            return;
//            this.j.startAnimation(AnimationUtils.loadAnimation(this, 2130968585));
//            this.i.sendEmptyMessage(40000);
//            this.i.sendEmptyMessageDelayed(50000, 500L);
//            return;
//        }
//        a(this, this.n.m());
//    }
//
//    protected void onCreate(Bundle paramBundle) {
//        super.onCreate(paramBundle);
//        this.k = d.b();
//        this.i.sendEmptyMessage(10000);
//    }
//
//    protected void onDestroy() {
//        super.onDestroy();
//        if (this.i != null) {
//            this.i.removeCallbacksAndMessages(null);
//            this.i = null;
//        }
//    }
//
//    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
//        return false;
//    }
//}
