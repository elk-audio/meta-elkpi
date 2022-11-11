PV = "1.0-rc1-yocto-build+${SRCREV}"

SRCREV = "ac05b9fcd9d95eaded4908c2a1774a85a9d12dbe"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DWITH_RPC_INTERFACE=TRUE \
    -DWITH_JACK=FALSE \
    -DWITH_VST3=TRUE \
    -DBUILD_TWINE=FALSE \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
    -DWITH_LINK=TRUE \
    -DWITH_LV2=TRUE \
    -DWITH_LV2_MDA_TESTS=FALSE \
"

# Add VST2 support if VST2SDK_PATH variable in local.conf is set and not empty.
EXTRA_OECMAKE += "${@bb.utils.contains('VST2SDK_PATH', \
                 '', \
                 ' -DWITH_VST2=TRUE -DVST2_SDK_PATH=' + d.getVar('VST2SDK_PATH'), \
                 ' -DWITH_VST2=FALSE ' \
                 , d)}"

INSANE_SKIP:${PN} += "dev-deps"

