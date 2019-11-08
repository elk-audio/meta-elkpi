# Specific sensei verson for sika
SRCREV = "97826487c0c680571abb3395db3962cb88bd4ea5"
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
