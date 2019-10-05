SUMMARY = "Lely core libraries"
DESCRIPTION = "The Lely core libraries are a collection of libraries \
designed to support the implementation robot control applications, on Linux, \
Windows or bare metal platforms. The primary components are an event \
loop/task scheduling mechanism, an I/O abstraction layer, and an extensive \
implementation of the CANopen protocol. The libraries have no external \
dependencies (apart from optional BlueZ headers on Linux)."

HOMEPAGE = "https://gitlab.com/lely_industries/lely-core"
SECTION = "libs"

LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "libsocketcan"

SRC_URI = "git://gitlab.com/lely_industries/lely-core;protocol=https"
SRCREV = "0b9b4d1a3074e94314c938d418aafcb9bfcbb834"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF += "--disable-python --disable-tests"

do_configure_prepend() {
    ( cd ${S}; autoreconf -i )
}
