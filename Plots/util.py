import pandas as pd

def read_data_block(file_path):
    # Einlesen der Datei, Kommentare (beginnend mit '#') ignorieren
    data = pd.read_csv(file_path, sep=' ', comment='#', header=None)

    # Entfernen von leeren Spalten, falls vorhanden
    data = data.dropna(axis=1, how='all')

    return data

# Beispielaufruf
file_path = 'deine_datei.out'  # Ersetze dies mit dem Pfad deiner Datei
data_block = read_data_block(file_path)

# Ausgabe des Data Blocks
print(data_block)
