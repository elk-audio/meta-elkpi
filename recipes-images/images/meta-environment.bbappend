# Add custom varialbes to be exported when SDK environment is setup
create_sdk_files:append() {
    # CMake sysroot should be the target sysroot
    echo 'export CMAKE_SYSROOT=$SDKTARGETSYSROOT' >> ${SDK_OUTPUT}/${SDKPATH}/environment-setup-${REAL_MULTIMACH_TARGET_SYS}

    # For CMake to find programs, it should look at the native SDK sysroot.
    echo 'export CMAKE_PROGRAM_PATH=$OECORE_NATIVE_SYSROOT/usr/bin' >> ${SDK_OUTPUT}/${SDKPATH}/environment-setup-${REAL_MULTIMACH_TARGET_SYS}
}
