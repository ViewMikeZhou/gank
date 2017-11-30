package com.chad.library.adapter.base.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;

import com.yanzhenjie.alertdialog.AlertDialog;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;


/**
 * Created by Administrator on 2017/3/17.
 * 使用方法:
 * Activity中
 *       @PermissionYes(1)    // 权限申请成功回调
        private void getMultiYes(@NonNull List<String> grantedPermissions) {
            if (grantedPermissions.size() >= 4) {
            isOk =true;
            if (!App.getSpCache().get(GlobalUtil.HASE_PERMISSION,false)){
            goRestart();
            }
            App.getSpCache().put(GlobalUtil.HASE_PERMISSION, true);
        }


         @PermissionNo(1)   // 权限申请失败回调
         private void getMultiNo(@NonNull List<String> deniedPermissions) {
             Toast.makeText(this, deniedPermissions.toString() + "申请失败", Toast.LENGTH_SHORT).show();
             if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {
             // 第一种：用默认的提示语。
             AndPermission.defaultSettingDialog(this, 1).show();
         }

}
 *
 *
 */

public class PermissionUtils {
    private static final int PERMISSION_REQUEST_CODE = 1;

    /**
     *
     * @param  context  可传入activity或fragment
     * @param permissionName 提示用户语言 ,string
     * @param permisson 所需权限可以是多个 例如:Manifest.permission.ACCESS_COARSE_LOCATION
     */
    public static void setPermisson(final Object context , final String permissionName, String...permisson){
        final Activity activity = getContext(context);
        AndPermission.with(activity).requestCode(PERMISSION_REQUEST_CODE)
                .permission(permisson)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, final Rationale rationale) {
                        AlertDialog.build(activity)
                                .setTitle("友好提醒")
                                .setMessage("您已拒绝过"+permissionName+"权限,将无法使用该功能,请允许打开"+permissionName+"权限")
                                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        rationale.resume();
                                    }
                                })
                                .setNegativeButton("禁止", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        rationale.cancel();
                                    }
                                }).show();
                    }
                })
                .start();   // send () 以过期

    }
    static Activity getContext(Object o) {
        if (o instanceof Activity)
            return (Activity) o;
        else if (o instanceof Fragment)
            return ((Fragment) o).getActivity();
        else if (o instanceof android.app.Fragment)
            return ((android.app.Fragment) o).getActivity();
        throw new IllegalArgumentException("The " + o.getClass().getName() + " is not support.");
    }
}
