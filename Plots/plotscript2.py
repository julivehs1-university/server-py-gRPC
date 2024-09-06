import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.backends.backend_pdf import PdfPages

# Daten als Dictionary
data = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [238.0, 129.0, 82.0, 63.0, 51.0, 43.0, 38.0, 32.0, 27.0, 23.0, 20.0, 18.0, 16.0, 15.0, 14.0, 13.0, 12.0, 11.0, 10.0, 10.0],
    'RayScanRange1': [94.0, 48.0, 31.0, 23.0, 18.0, 14.0, 12.0, 10.0, 6.0, 4.0, 6.0, 4.0, 3.0, 2.0, 2.0, 3.0, 2.0, 1.0, 1.0, 1.0],
    'RayScanRange4': [30.0, 12.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0]
}

# Daten in ein Pandas DataFrame umwandeln
df = pd.DataFrame(data)

# Funktion zum Erstellen des Plots und Speichern in PDF
def plot_data_and_save_pdf(df, output_pdf_path):
    # Plot erstellen
    plt.figure(figsize=(10, 6))
    plt.plot(df['numOfRobots'], df['DefaultCellScan'], label='DefaultCellScan', marker='o')
    plt.plot(df['numOfRobots'], df['RayScanRange1'], label='RayScan Range 1', marker='o')
    plt.plot(df['numOfRobots'], df['RayScanRange4'], label='RayScan Range 4', marker='o')

    # Achsenbeschriftung und Titel
    plt.xlabel('Number of Robots')
    plt.ylabel('Revisit Percentile 95')
    plt.title('Revisit Percentile 95 vs Number of Robots')
    plt.legend()

    # Speichern als PDF
    with PdfPages(output_pdf_path) as pdf:
        pdf.savefig()
        plt.close()

# Ausgabepfad für die PDF-Datei
output_pdf_path = 'output_plot.pdf'

# Plot erstellen und speichern
plot_data_and_save_pdf(df, output_pdf_path)
