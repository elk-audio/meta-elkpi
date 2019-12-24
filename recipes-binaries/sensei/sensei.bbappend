DESCRIPTION = "Specific sensei version and build options for the elk pi"
SRCREV = "3345a575b8bf99d375c0e8d5f5636e01bf6d2655"
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