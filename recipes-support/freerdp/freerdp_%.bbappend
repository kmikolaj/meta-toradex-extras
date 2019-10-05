PACKAGECONFIG_append_tegra = " \
    gstreamer010 \
"
PACKAGECONFIG_remove_tegra = " \
    gstreamer \
"
PACKAGECONFIG[gstreamer010] = "-DWITH_GSTREAMER_0_10=ON,-DWITH_GSTREAMER_0_10=OFF,gstreamer gst-plugins-base"
