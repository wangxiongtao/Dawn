package com.dawn.modules.workmanager;

import android.support.annotation.NonNull;

import java.util.Set;
import java.util.UUID;

import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;

/**
 * Created by Administrator on 2018/5/23 0023.
 */

public class MyWork extends WorkRequest {
    protected MyWork(@NonNull UUID id, @NonNull WorkSpec workSpec, @NonNull Set<String> tags) {
        super(id, workSpec, tags);
    }
}
