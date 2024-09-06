import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.backends.backend_pdf import PdfPages
import os

# Funktion zum Einlesen der Datei und Erstellen des Plots
def plot_data_from_file(file_path):
    # Einlesen der Datei
    data = pd.read_csv(file_path, sep=' ', comment='#', header=None)

    # Spaltennamen manuell setzen (je nach Struktur der Datei)
    data.columns = ['numOfRobots', 'DefaultCellScan', 'RayScanRange1', 'RayScanRange4']

    # Plot erstellen
    plt.figure(figsize=(10, 6))
    plt.plot(data['numOfRobots'], data['DefaultCellScan'], label='DefaultCellScan', marker='o')
    plt.plot(data['numOfRobots'], data['RayScanRange1'], label='RayScan Range 1', marker='o')
    plt.plot(data['numOfRobots'], data['RayScanRange4'], label='RayScan Range 4', marker='o')

    # Achsenbeschriftung und Titel
    plt.xlabel('Number of Robots')
    plt.ylabel('Revisit Percentile 95')
    plt.title(f'Revisit Percentile 95 vs Number of Robots - {os.path.basename(file_path)}')
    plt.legend()

    # Pfad für die PDF-Datei (Dateiname übernehmen und ".pdf" hinzufügen)
    output_pdf_path = file_path.replace('.out', '.pdf')

    # PDF-Datei speichern
    with PdfPages(output_pdf_path) as pdf:
        pdf.savefig()

    plt.close()

# Liste aller Dateien, die geplottet werden sollen
file_paths = [
    '/mnt/data/LocalMinima_communication_four_hop.out',
    '/mnt/data/LocalMinima_communication_no_hop.out',
    '/mnt/data/LocalMinima_communication_one_hop.out',
    '/mnt/data/LocalMinima_communication_two_hop.out',
    '/mnt/data/MaxReward_num_robots_exponential_off.out',
    '/mnt/data/MaxReward_num_robots_exponential_on.out',
    '/mnt/data/MaxReward_parameter_exponential_off.out',
    '/mnt/data/MaxReward_parameter_exponential_on.out',
    '/mnt/data/RandomWalk.out'
]

# Für jede Datei den Plot erstellen und speichern
for file_path in file_paths:
    plot_data_from_file(file_path)
