DESCRIPTION = "Specific Sushi version and build options for the Elk pi"
SRCREV = "e0eeac32fa8f1ed18f0a19d54f8d04c4728e9ece"
PV = "0.9.0+${SRCREV}"

DEPENDS += "grpc grpc-native protobuf protobuf-native protobuf-c protobuf-c-native"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release \
                  -DWITH_RPC_INTERFACE=TRUE \
                  -DWITH_JACK=FALSE \
                  -DWITH_VST3=TRUE \
                  -DBUILD_TWINE=FALSE \
                  -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
                  -DWITH_UNIT_TESTS=FALSE \
                  -DVST2_SDK_PATH=${WORKDIR}/git/third-party/vstsdk2.4 \
                  "

# To enable vst support set the following variables
# EXTRA_OECMAKE += -DWITH_VST2=TRUE
# EXTRA_OECMAKE += -DVST2_SDK_PATH=< path to the vst2 sdk in the build machine>

INSANE_SKIP_${PN} += "dev-deps"