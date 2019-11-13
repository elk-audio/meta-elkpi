# Specific sensei verson for sika
SRCREV = "92051d529090d20751540401484ce21c3ca0292c"
PV = "0.2.0+${SRCREV}"

DEPENDS += "xenomai-lib"

EXTRA_OECMAKE = " \
    -DCMAKE_BUILD_TYPE=Release \
    -DWITH_UNIT_TESTS=FALSE \
    -DWITH_ELK_PI_GPIO=TRUE \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DGPIO_PROTOCOL_BUILD_CLIENT_LIB=TRUE \
    -DCMAKE_SKIP_RPATH=TRUE \
    "
