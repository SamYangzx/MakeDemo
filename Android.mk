
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res
LOCAL_PACKAGE_NAME := HelloAndroid

LOCAL_USE_FRAMEWORK_GOME:= true

LOCAL_APK_LIBRARIES := Settings
LOCAL_CERTIFICATE := platform
include $(BUILD_PACKAGE)
