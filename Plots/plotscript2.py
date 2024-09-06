import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.backends.backend_pdf import PdfPages

# Daten als Dictionary
# data GlobalMinima
dataGlobalMinima = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [238.0, 129.0, 82.0, 63.0, 51.0, 43.0, 38.0, 32.0, 27.0, 23.0, 20.0, 18.0, 16.0, 15.0, 14.0, 13.0, 12.0, 11.0, 10.0, 10.0],
    'RayScanRange1': [94.0, 48.0, 31.0, 23.0, 18.0, 14.0, 12.0, 10.0, 6.0, 4.0, 6.0, 4.0, 3.0, 2.0, 2.0, 3.0, 2.0, 1.0, 1.0, 1.0],
    'RayScanRange4': [30.0, 12.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0]
}
#data 
dataLocalMinimaFourHop = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [244.0, 217.0, 235.0, 225.0, 206.0, 131.0, 167.0, 121.0, 120.0, 82.0, 81.0, 61.0, 50.0, 56.0, 38.0, 31.0, 32.0, 29.0, 16.0, 22.0],
    'RayScanRange1': [122.0, 120.0, 97.0, 56.0, 27.0, 9.0, 5.0, 3.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 1.0, 2.0, 1.0],
    'RayScanRange4': [66.0, 21.0, 6.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0]
}
#data 
dataLocalMinimaNoHop = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [262.0, 125.0, 62.0, 49.0, 40.0, 35.0, 29.0, 27.0, 27.0, 24.0, 21.0, 19.0, 19.0, 19.0, 17.0, 17.0, 15.0, 13.0, 12.0, 14.0],
    'RayScanRange1': [118.0, 65.0, 10.0, 5.0, 1.0, 2.0, 1.0, 1.0, 12.0, 11.0, 9.0, 1.0, 8.0, 1.0, 1.0, 6.0, 6.0, 4.0, 1.0, 1.0],
    'RayScanRange4': [38.0, 1.0, 8.0, 1.0, 4.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0]
}
#data 
dataLocalMinimaOneHop = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [230.0, 248.0, 248.0, 206.0, 203.0, 178.0, 161.0, 141.0, 106.0, 71.0, 50.0, 51.0, 53.0, 36.0, 27.0, 27.0, 16.0, 16.0, 11.0, 11.0],
    'RayScanRange1': [134.0, 128.0, 76.0, 56.0, 37.0, 27.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0],
    'RayScanRange4': [46.0, 19.0, 6.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0]
}
#data 
dataLocalMinimaTwoHop = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [250.0, 260.0, 229.0, 245.0, 201.0, 185.0, 168.0, 94.0, 101.0, 80.0, 71.0, 62.0, 56.0, 32.0, 21.0, 25.0, 20.0, 13.0, 12.0, 13.0],
    'RayScanRange1': [126.0, 113.0, 83.0, 73.0, 34.0, 32.0, 3.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 1.0, 2.0, 1.0, 1.0],
    'RayScanRange4': [44.0, 26.0, 3.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0]
}
#data 
dataMaxRewardNREOff = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [77.0, 37.0, 24.0, 17.0, 13.0, 11.0, 9.0, 7.0, 7.0, 5.0, 5.0, 4.0, 3.0, 3.0, 3.0, 2.0, 1.0, 1.0, 1.0, 1.0]
}
#data 
dataMaxRewardNREOn = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [79.0, 43.0, 25.0, 18.0, 14.0, 11.0, 9.0, 7.0, 7.0, 5.0, 5.0, 4.0, 3.0, 3.0, 3.0, 2.0, 1.0, 1.0, 1.0, 1.0]
}
#data 
dataMaxRewardPEOff = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [],
    'RayScanRange1': [],
    'RayScanRange4': []
}
#data 
dataMaxRewardPEOn = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [],
    'RayScanRange1': [],
    'RayScanRange4': []
}
#data 
dataRandomWalk = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [572.0, 262.0, 170.0,121, 95.0, 75.0, 62.0, 54.0, 46.0, 40.0, 36.0, 32.0, 30.0, 27.0, 25.0, 23.0, 21.0, 20.0, 18.0, 17.0],
    'RayScanRange1': [120.0, 54.0, 34.0, 24.0, 19.0, 16.0, 13.0, 12.0, 9.0, 8.0, 8.0, 6.0, 6.0, 6.0, 5.0, 4.0, 4.0, 4.0, 4.0, 4.0],
    'RayScanRange4': [12.0, 6.0, 4.0, 2.0, 2.0, 2.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 ]
}
#data 
dataMaxRewardNREOANC = {
    'numOfRobots': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
    'DefaultCellScan': [77.0, 39.0, 26.0, 19.0, 15.0, 12.0, 10.0, 8.0, 7.0, 6.0, 5.0, 5.0, 4.0, 3.0, 3.0, 3.0, 2.0, 2.0, 2.0, 1.0]
}

# Daten in ein Pandas DataFrame umwandeln
df = pd.DataFrame(dataGlobalMinima)
#df = pd.DataFrame(dataLocalMinimaFourHop)
#df = pd.DataFrame(dataLocalMinimaNoHop)
#df = pd.DataFrame(dataLocalMinimaOneHop)
#df = pd.DataFrame(dataLocalMinimaTwoHop)
#df = pd.DataFrame(dataMaxRewardNREOff)
#df = pd.DataFrame(dataMaxRewardNREOn)
#df = pd.DataFrame(dataMaxRewardPEOff)
#df = pd.DataFrame(dataMaxRewardPEOn)
#df = pd.DataFrame(dataMaxRewardNREOANC)
#df = pd.DataFrame(dataRandomWalk)

# Funktion zum Erstellen des Plots und Speichern in PDF
def plot_data_and_save_pdf(df, output_pdf_path):
    # Plot erstellen
    plt.figure(figsize=(10, 6))
    plt.plot(df['numOfRobots'], df['DefaultCellScan'], label='DefaultCellScan', marker='o')
    plt.plot(df['numOfRobots'], df['RayScanRange1'], label='RayScan Radius 1', marker='o')
    plt.plot(df['numOfRobots'], df['RayScanRange4'], label='RayScan Radius 4', marker='o')

    # Achsenbeschriftung und Titel
    plt.xlabel('Anzahl Roboter')
    plt.ylabel('Revisit 95%-Perzentil')
    plt.legend()

    # Speichern als PDF
    with PdfPages(output_pdf_path) as pdf:
        pdf.savefig()
        plt.close()

# Ausgabepfad für die PDF-Datei
output_pdf_path = 'GlobalMinima.pdf'
#output_pdf_path = 'LocalMinima_four_hop.pdf'
#output_pdf_path = 'LocalMinima_no_hop.pdf'
#output_pdf_path = 'LocalMinima_one_hop.pdf'
#output_pdf_path = 'LocalMinima_two_hop.pdf'
#output_pdf_path = 'MaxReward_num_robots_exponential_off.pdf'
#output_pdf_path = 'MaxReward_num_robots_exponential_on.pdf'
#output_pdf_path = 'MaxReward_parameter_exponential_off.pdf'
#output_pdf_path = 'MaxReward_parameter_exponential_on.pdf'
#output_pdf_path = 'MaxReward_num_robots_exponential_off_and_no_communication.pdf'
#output_pdf_path = 'RandomWalk.pdf'

# Plot erstellen und speichern
plot_data_and_save_pdf(df, output_pdf_path)
