# Recipe append for raspa for elk pi boards

SRC_URI = "git://github.com/elk-audio/raspa;protocol=https;nobranch=1"
SRCREV = "ea38a38c893445e4d01d0e7c255cea6e1c8bb694"

PV = "0.1.0+${SRCREV}"

NUM_INPUT_CHANNELS = "6"
NUM_OUTPUT_CHANNELS = "8"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release \
                  -DBUILD_GMOCK=FALSE \
                  -DINSTALL_GTEST=FALSE \
                  -DRASPA_N_INPUT_CHANNELS=${NUM_INPUT_CHANNELS} \
                  -DRASPA_N_OUTPUT_CHANNELS=${NUM_OUTPUT_CHANNELS} \
                  -DRASPA_WITH_TESTS=FALSE \
                  -DRASPA_WITH_APPS=OFF \
                  -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
                  -DWITH_UNIT_TESTS=FALSE \
                  "