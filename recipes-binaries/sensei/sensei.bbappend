# Specific sensei verson for sika
SRCREV = "3216bd19e85e134cee0ccc4d93924d5cd2df4df4"

PV = "0.2.0+${SRCREV}"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release -DWITH_UNIT_TESTS=FALSE"