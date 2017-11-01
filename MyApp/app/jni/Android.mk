LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := dawn
LOCAL_SRC_FILES := Test.c
include $(BUILD_SHARED_LIBRARY)
LOCAL_LDFLAGS += -fuse-ld=bfd