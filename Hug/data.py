class Poll:
    def __init__(self):
        # List of candidate objects
        self.candidate = []
        # List of region objects
        self.regions = []
        self.date = 0

    # Returns list of all regions
    def get_regions(self):
        return self.regions

    # Returns list of all candidates
    def get_candidates(self):
        return self.candidate

    # Returns date
    def get_date(self):
        return self.date


class Region:
    def __init__(self, name):
        self.name = name
        self.votes = {}

    # Get votes for candidate
    def get_votes_candidate(self, candidate):
        for x in self.votes:
            if x == candidate:
                return self.votes[x]


class Candidates:
    def __init__(self, name, info, politicalParty, region):
        """Alls ekki heilagt, má alveg bæta ehv við"""
        self.name = name
        self.info = info # some info
        self.politicalParty = politicalParty
        self.region = region
        #self.votes = getCandidatesVotes()


# Dæmi um hvernig data væri sett up
poll = Poll()
texas = Region("Texas")
california = Region("California")
poll.regions.append(texas)
poll.regions.append(california)
john = Candidates("john", "?", "democratic", texas)
william = Candidates("William", "?", "republican", california)
poll.candidate.append(john)
poll.candidate.append(william)
poll.regions[0].votes[john] = 200
poll.regions[0].votes[william] = 300
poll.regions[1].votes[john] = 400
poll.regions[1].votes[william] = 200
