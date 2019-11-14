# Recipe append for sushi for the product.

SRCREV = "c213d30da76c0e8c67d6b8ce6bf6e447d20a63be"
VST2SDK_REV="c4698a9e815a081d836a61d541da0b05be740456"

PV = "0.8.0+${SRCREV}"

DEPENDS += "grpc grpc-native protobuf protobuf-native protobuf-c protobuf-c-native"

# Remove LIC checksum on vst2sdk as it is now a private repo
LIC_FILES_CHKSUM_remove = " \
    file://third-party/vstsdk2.4/vstgui.sf/vstgui/Documentation/html/license.html;md5=a0b7291eff176aa998343351b3abcdba \
    file://third-party/vstsdk2.4/doc/html/license.html;md5=c3b5d06993a4faa04988fc48571b7e1f \
    "

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release \
                  -DWITH_RPC_INTERFACE=TRUE \
                  -DWITH_JACK=FALSE \
                  -DWITH_VST3=TRUE \
                  -DWITH_VST2=TRUE \
                  -DBUILD_TWINE=FALSE \
                  -DRASPA_WITH_TESTS=FALSE \
                  -DRASPA_WITH_UCONTROLLER=FALSE \
                  -DAUDIO_BUFFER_SIZE=64 \
                  -DXENOMAI_AUDIO_CHANNELS=8 \
                  -DXENOMAI_AUDIO_SAMPLE_RATE=48000 \
                  -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
                  -DWITH_UNIT_TESTS=FALSE \
                  -DVST2_SDK_PATH=${WORKDIR}/git/third-party/vstsdk2.4 \
                  "

INSANE_SKIP_${PN} += "dev-deps"

do_vst2sdk_fetch () {
    git clone git@bitbucket.org:mindswteam/vstsdk2.4.git -b master ${WORKDIR}/git/third-party/vstsdk2.4
    git -C ${WORKDIR}/git/third-party/vstsdk2.4 checkout ${VST2SDK_REV}
}
addtask do_vst2sdk_fetch after do_patch before do_configure
