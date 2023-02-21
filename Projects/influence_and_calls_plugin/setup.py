from setuptools import setup, find_packages

setup(
    name="slither-influence-and-calls-printer",
    description="This printer allows for the analysis of influence between variables and function calls.",
    url="",
    author="Jan-Philipp Toeberg",
    version="0.1",
    packages=find_packages(),
    python_requires=">=3.6",
    install_requires=["slither-analyzer==0.8.0"],
    entry_points={
        "slither_analyzer.plugin": "slither my-plugin=influence_and_calls:make_plugin",
    },
)
