# Specific sensei verson for sika
SRCREV = "b32873852d9c326c40970af9b10b3206f60b2b31"
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
