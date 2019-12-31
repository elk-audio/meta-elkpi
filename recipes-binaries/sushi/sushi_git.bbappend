DEPENDS += "\
    grpc \
    grpc-native \
    protobuf \
    protobuf-native \
    protobuf-c \
    protobuf-c-native\
"

PV = "0.9.0+${SRCREV}"

SRCREV = "e0eeac32fa8f1ed18f0a19d54f8d04c4728e9ece"

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