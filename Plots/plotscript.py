import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.backends.backend_pdf import PdfPages
import matplotlib.backends.backend_svg as svg

# Funktion zum Einlesen der Datei und Erstellen des Plots
def plot_data_from_file(file_path, output_pdf_path, svg_file_path):
    # Einlesen der Datei
    data = pd.read_csv(file_path, sep=' ', comment='#')

    # Plot erstellen
    plt.figure(figsize=(10, 6))
    plt.plot(data['numOfRobots'], data['DefaultCellScan_EvaluationScanCapabilityWrapper_revisit_percentil95'], label='DefaultCellScan', marker='o')
    plt.plot(data['numOfRobots'], data['RayScanCapabilities_range_1_EvaluationScanCapabilityWrapper_revisit_percentil95'], label='RayScan Range 1', marker='o')
    plt.plot(data['numOfRobots'], data['RayScanCapabilities_range_4_EvaluationScanCapabilityWrapper_revisit_percentil95'], label='RayScan Range 4', marker='o')

    # Achsenbeschriftung und Titel
    plt.xlabel('Number of Robots')
    plt.ylabel('Revisit Percentile 95')
    plt.title('Revisit Percentile 95 vs Number of Robots')
    plt.legend()

    # SVG-Datei speichern
    plt.savefig(svg_file_path, format='svg')

    # PDF-Datei speichern
    with PdfPages(output_pdf_path) as pdf:
        pdf.savefig()

    plt.close()

# Pfade für Datei und Ausgabe
file_path = 'data.txt'  # Pfad zur Datei mit den Daten
output_pdf_path = 'output_plot.pdf'  # Ausgabepfad für die PDF-Datei
svg_file_path = 'output_plot.svg'  # Ausgabepfad für die SVG-Datei

# Plot erstellen und speichern
plot_data_from_file(file_path, output_pdf_path, svg_file_path)
