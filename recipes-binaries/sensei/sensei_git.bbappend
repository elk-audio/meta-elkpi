# Note: This is an obslete recipe. Supported in older version of ELk Audio Os (0.11.0)
DEPENDS += "xenomai-lib"
PV = "0.3.0+${SRCREV}"
SRCREV = "d4f93e7d6b58d0cd1a9421bfa7033f0e839f1ff7"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DWITH_UNIT_TESTS=FALSE \
    -DWITH_GPIO_LOGIC=TRUE \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DGPIO_PROTOCOL_BUILD_CLIENT_LIB=TRUE \
    -DGPIO_LOG_LEVEL=error \
    -DCMAKE_SKIP_RPATH=TRUE \
"
