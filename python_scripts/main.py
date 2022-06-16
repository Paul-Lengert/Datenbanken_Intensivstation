import datetime
import random

state = ["aktiv", "genesen", "verstorben"]
bad_state = ["genesen", "verstorben"]

diseases = ["Addison-Krise", "Cushing-Syndrom", "Gallensteine", "Leberentzündung", "Magengeschwür",
            "Niereninsuffizienz", "Nierensteine", "Speiseröhrenentzündung", "Bauchspeicheldrüsenentzündung",
            "Diabetes", "Kropf", "Pankreaskarzinom", "Schilddrüsenentzündung", "Anämie", "Bluthochdruck",
            "Gelbsucht", "Herzinfarkt", "Schlaganfall", "Anämie", "Bluthochdruck", "Gelbsucht", "Herzinfarkt",
            "Schlaganfall", "Afrikanisches Zeckenstichfieber", "Borreliose", "Meningoenzephalitis", "Colitis ulcerosa",
            "Morbus Hodgkin", "Morbus Crohn", "SLE"]

rooms = [101, 102, 103, 104, 105,
         106, 107, 108, 109, 110,
         111, 112, 113, 114, 115]

doctors = ["Dr. Gustav Storch", "Dr. Petra Steinkowski", "Dr. Dilay Ayad", "Prof. Dr. Huong Nguyen",
           "Dr. Joseph Maisch"]


def birthday():
    start_date = datetime.date(1930, 1, 1)
    end_date = datetime.date(2020, 1, 1)
    time_between_dates = end_date - start_date
    days_between_dates = time_between_dates.days
    random_number_of_days = random.randrange(days_between_dates)
    random_date = start_date + datetime.timedelta(days=random_number_of_days)
    return random_date.strftime('%d.%m.%Y')


def treatDate():
    start_date = datetime.date(2011, 1, 1)
    end_date = datetime.date(2020, 1, 1)
    time_between_dates = end_date - start_date
    days_between_dates = time_between_dates.days
    random_number_of_days = random.randrange(days_between_dates)
    random_date = start_date + datetime.timedelta(days=random_number_of_days)
    return random_date.strftime('%Y-%m-%d')


def firstname_male(firstName):
    firstNameList = []
    with open(firstName) as firstNameFile:
        while firstNameFile.readline():
            line = firstNameFile.readline().replace("\n", "")
            firstNameList.append(line)
    return random.choice(firstNameList)


def firstname_female(firstName):
    firstNameList = []
    with open(firstName) as firstNameFile:
        while firstNameFile.readline():
            line = firstNameFile.readline().replace("\n", "")
            firstNameList.append(line)
    return random.choice(firstNameList)


def lastname(lastName):
    lastNameList = []
    with open(lastName) as lastNameFile:
        while lastNameFile.readline():
            line = lastNameFile.readline().replace("\n", "")
            lastNameList.append(line)
    return random.choice(lastNameList)


def KVNumber():
    alphabet = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
    randomNumber = random.randint(100000000, 999999999)
    kvAlphabet = random.choice(alphabet)
    kv = kvAlphabet + str(randomNumber)
    return kv


def createMalePatients(num, file):
    room_counter = 0
    for i in range(0, num):
        with open(file, 'r') as pa:
            current_text = pa.read()
        with open(file, 'a') as patients:
            current_kv = KVNumber()
            current_room = "~"
            current_state = random.choice(state)
            current_doc = random.choice(doctors)
            # Belegung des konkreten Raumes
            if current_state == "aktiv" and room_counter < 10:
                current_room = random.choice(rooms)
                while (current_room < 106 and current_text.count(',' + str(current_room) + ',') >= 1) or (
                        105 < current_room <= 115 and current_text.count(',' + str(current_room) + ',') >= 2):
                    current_room = random.choice(rooms)
                room_counter += 1
            else:
                # bei Überbelegung leider verstorben oder blitzgeheilt
                current_state = random.choice(bad_state)

            # Überwachung, dass sich kein Arzt überarbeitet
            while current_state == "aktiv" and current_text.count(current_doc) >= 20:
                current_doc = random.choice(doctors)
            # Einzigartigkeit der KV
            while current_kv in current_text:
                current_kv = KVNumber()

            patients.writelines(current_kv + ',' + firstname_male("MaenlicheVornamen.txt") + ' ' + lastname(
                "Nachnamen.txt") + ',' + birthday() + ',M,' + current_state + ',' + str(
                current_room) + ',' + random.choice(diseases) + ',' + current_doc + "\n")
        print(f"added number {i} of male patients.")


def createFemalePatients(num, file):
    room_counter = 0
    for i in range(0, num):
        with open(file, 'r') as pa:
            current_text = pa.read()
        with open(file, 'a') as patients:
            current_kv = KVNumber()
            current_room = "~"
            current_state = random.choice(state)
            current_doc = random.choice(doctors)
            # Belegung des konkreten Raumes
            if current_state == "aktiv" and room_counter < 10:
                current_room = random.choice(rooms)
                while (current_room < 106 and current_text.count(',' + str(current_room) + ',') >= 1) or (
                        105 < current_room <= 115 and current_text.count(',' + str(current_room) + ',') >= 2):
                    current_room = random.choice(rooms)
                room_counter += 1
            else:
                # bei Überbelegung leider verstorben oder blitzgeheilt
                current_state = random.choice(bad_state)

            # Überwachung, dass sich kein Arzt überarbeitet
            while current_state == "aktiv" and current_text.count(current_doc) >= 20:
                current_doc = random.choice(doctors)
            # Einzigartigkeit der KV
            while current_kv in current_text:
                current_kv = KVNumber()
            patients.write(
                current_kv + ',' + firstname_female("WeiblicheVornamen.txt") + ' ' + lastname(
                    "Nachnamen.txt") + ',' + birthday() + ',W,' + current_state + ',' + str(
                    current_room) + ',' + random.choice(diseases) + ',' + current_doc + "\n")
        print(f"added number {i} of female patients.")


def treatments():
    with open("../Ressources/treatments.csv", 'w') as treats, open("../Ressources/PatientList.csv", 'r') as pat:
        id = 1
        currentPat = pat.readline();
        for i in range(0, 100):
            currentPat = pat.readline().split(',')
            fromDate = treatDate()
            toDate = treatDate()
            currentDocs = ""
            secondDocs = ""
            if currentPat[7] == "Prof. Dr. Huong Nguyen\n":
                currentDocs = "A1"
                secondDocs = "A6"
            elif currentPat[7] == "Dr. Gustav Storch\n":
                currentDocs = "A2"
                secondDocs = "A7"
            elif currentPat[7] == "Dr. Petra Steinkowski\n":
                currentDocs = "A3"
                secondDocs = "A8"
            elif currentPat[7] == "Dr. Dilay Ayad\n":
                currentDocs = "A4"
                secondDocs = "A9"
            elif currentPat[7] == "Dr. André Pierowski\n":
                currentDocs = "A5"
                secondDocs = "A10"
            while toDate < fromDate:
                toDate = treatDate()
            if currentPat[4] == "aktiv":
                continue;
            else:
                treats.write(str(id) + ',' + currentPat[0] + ',' + currentPat[4] + ',' + currentPat[
                    6] + ',' + currentDocs + ',' + str(fromDate) + ',' + str(toDate) + "\n");
                treats.write(str(id) + ',' + currentPat[0] + ',' + currentPat[4] + ',' + currentPat[
                    6] + ',' + secondDocs + ',' + str(fromDate) + ',' + str(toDate) + "\n");
                id += 1


def shift():
    with open("../Ressources/shift.csv", 'w') as sh:
        id = 25430
        # Generiert die Woche
        for i in range(1, 55):
            # Generiert die Frühschicht
            for j in range(1, 6):
                sh.write(str(id) + ',' + str(i) + ",2022,Frühschicht,A" + str(j) + "\n")
                id += 1
            for g in range(1, 11):
                sh.write(str(id) + ',' + str(i) + ",2022,Frühschicht,P" + str(g) + "\n")
                id += 1
            # Generiert die Tagesschicht
            for h in range(6, 11):
                sh.write(str(id) + ',' + str(i) + ",2022,Tagesschicht,A" + str(h) + "\n")
                id += 1
            for k in range(11, 21):
                sh.write(str(id) + ',' + str(i) + ",2022,Tagesschicht,P" + str(k) + "\n")
                id += 1
            # Generiert die Nachtschicht
            for l in range(11, 13):
                sh.write(str(id) + ',' + str(i) + ",2022,Nachtschicht,A" + str(l) + "\n")
                id += 1
            for m in range(22, 28):
                sh.write(str(id) + ',' + str(i) + ",2022,Nachtschicht,P" + str(m) + "\n")
                id += 1


shift()
