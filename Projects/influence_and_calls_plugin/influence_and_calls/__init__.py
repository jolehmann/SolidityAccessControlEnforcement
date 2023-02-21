from influence_and_calls.printers.influence_and_calls import InfluenceAndCallsPrinter


def make_plugin():
    plugin_detectors = []
    plugin_printers = [InfluenceAndCallsPrinter]

    return plugin_detectors, plugin_printers
