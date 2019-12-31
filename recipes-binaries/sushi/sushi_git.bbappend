DEPENDS += "\
    grpc \
    grpc-native \
    protobuf \
    protobuf-native \
    protobuf-c \
    protobuf-c-native\
"

PV = "0.9.1+${SRCREV}"

SRCREV = "868dd3c1afcea5655c6f93d058978df62dafb08c"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DWITH_RPC_INTERFACE=TRUE \
    -DWITH_JACK=FALSE \
    -DWITH_VST3=TRUE \
    -DBUILD_TWINE=FALSE \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
"

# To enable vst support set the following variables
EXTRA_OECMAKE += " -DWITH_VST2=FALSE"
# EXTRA_OECMAKE += " -DVST2_SDK_PATH=< path to the vst2 sdk in the build machine>"

INSANE_SKIP_${PN} += "dev-deps"